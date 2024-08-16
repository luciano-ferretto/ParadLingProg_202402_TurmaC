//Sem Parâmetros
const greet = () => console.log("Hello, World!");
greet();  // Saída: Hello, World!

//Com um parâmetro
const square = x => x * x;
console.log(square(5));  // Saída: 25

//Com múltiplos parâmetros
const add = (x, y) => x + y;
console.log(add(3, 4));  // Saída: 7

//Com bloco de código
const multiplyAndPrint = (x, y) => {
    const result = x * y;
    console.log(result);
};
multiplyAndPrint(3, 4);  // Saída: 12

//Passando como parâmetro para uma Função de Ordem Superior
const numbers = [1, 2, 3, 4];
const doubled = numbers.map(num => num * 2);
console.log(doubled);  // Saída: [2, 4, 6, 8]


