
function calcularAreaTriangulo(base, altura) {
    if (base <= 0 || altura <= 0) {
        throw new Error("La base y la altura deben ser números positivos.");
    }
    const area = (base * altura) / 2;
    return area.toFixed(2);
}

function calcularAreaCirculo(radio) {
    if (radio <= 0) {
        throw new Error("El radio debe ser un número positivo.");
    }
    const PI = Math.PI;
    const area = PI * Math.pow(radio, 2);
    return area.toFixed(2);
}

try {
    const base = 10;
    const altura = 5;
    const radio = 7;

    const areaTriangulo = calcularAreaTriangulo(base, altura);
    const areaCirculo = calcularAreaCirculo(radio);

    console.log("El área del triángulo es:", areaTriangulo);
    console.log("El área del círculo es:", areaCirculo);
} catch (error) {
    console.error(error.message);
}