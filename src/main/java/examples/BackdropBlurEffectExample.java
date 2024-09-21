package examples;

import gsdk.App;
import gsdk.Resource;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;

public class BackdropBlurEffectExample {
    public static void main(String[] args) {
        // Создаем окно
        App.window = new RenderWindow(new VideoMode(800, 600), "Blur Effect Example", WindowStyle.DEFAULT);

        // Загружаем текстуру
        Texture texture = new Texture();
        texture = Resource.loadTexture("/img/butterfly.png"); // Путь к изображению

        // Создаем спрайт для отображения изображения
        Sprite sprite = new Sprite(texture);

        // Задаем размер двигаемого квадрата
        RectangleShape movingRectangle = new RectangleShape(new Vector2f(300, 300));
        movingRectangle.setFillColor(Color.TRANSPARENT);
        movingRectangle.setOutlineColor(Color.RED);
        movingRectangle.setOutlineThickness(2);

        // Для эффекта размытия будем использовать дополнительный спрайт и шейдер
        RenderTexture renderTexture = new RenderTexture();
        try {
            renderTexture.create(App.window.getSize().x, App.window.getSize().y); // Размер окна
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Shader blurShader = new Shader();
        try {
            blurShader.loadFromSource(
                    Resource.readDataFromStream(Resource.getAsStream("/shaders/blur.frag")), Shader.Type.FRAGMENT
            );
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        while (App.window.isOpen()) {
            try {
                renderTexture.create(App.window.getSize().x, App.window.getSize().y); // Размер окна
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            // Обрабатываем события
            App.checkEvents();

            // Обновляем положение квадрата в зависимости от мыши
            Vector2f mousePosition = new Vector2f(Mouse.getPosition(App.window).x, Mouse.getPosition(App.window).y);
            movingRectangle.setPosition(mousePosition.x - movingRectangle.getSize().x / 2, mousePosition.y - movingRectangle.getSize().y / 2);

            // Очищаем текстуру и рисуем исходное изображение
            renderTexture.clear();
            renderTexture.draw(sprite);

            // Применяем размытие к области за пределами прямоугольника
            blurShader.setParameter("blur_radius", 5f); // Параметр размытия
            blurShader.setParameter("rect_position", new Vector2f(
                            movingRectangle.getPosition().x,
                            -movingRectangle.getPosition().y + App.window.getSize().y - movingRectangle.getSize().y
                    )
            );
            blurShader.setParameter("rect_size", movingRectangle.getSize());

            // Рисуем изображение с применением шейдера
            renderTexture.display();
            Sprite blurredSprite = new Sprite(renderTexture.getTexture());

            // Очищаем окно
            App.window.clear();

            // Рисуем размытое изображение
            App.window.draw(blurredSprite, new RenderStates(blurShader));


            // Отображаем результат
            App.window.display();
        }
    }
}
