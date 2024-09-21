uniform sampler2D texture;
uniform vec2 rect_position;
uniform vec2 rect_size;
uniform float blur_radius;

void main() {
    vec2 texCoords = gl_TexCoord[0].xy;

    // Определяем, находится ли текущая точка внутри прямоугольника
    if (texCoords.x > rect_position.x / 800.0 && texCoords.x < (rect_position.x + rect_size.x) / 800.0 &&
        texCoords.y > rect_position.y / 600.0 && texCoords.y < (rect_position.y + rect_size.y) / 600.0) {
        // Если внутри, то выводим оригинальные цвета


        // Если снаружи, применяем размытие
                vec4 color = vec4(0.0);
                int samples = 10;
                for (int x = -samples; x <= samples; ++x) {
                    for (int y = -samples; y <= samples; ++y) {
                        color += texture2D(texture, texCoords + vec2(x, -y) * blur_radius / 800.0);
                    }
                }
                color /= (float((samples * 2 + 1) * (samples * 2 + 1)));
                gl_FragColor = color;
    } else {
        gl_FragColor = texture2D(texture, texCoords);
    }
}