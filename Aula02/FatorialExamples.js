console.time('Recursivo');

// Fatorial Recursivo
function factorialRecursive(n) {
    if (n === 0 || n === 1) {
        return 1;
    } else {
        return n * factorialRecursive(n - 1);
    }
}

// Fatorial Iterativo
function factorialIterative(n) {
    let result = 1;
    for (let i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

// Teste de desempenho
const n = 50;

// Tempo do fatorial recursivo
console.time('recursivo');
const factorialRecursiveResult = factorialRecursive(n);
console.timeEnd('recursivo');
console.log(`Recursivo: Resultado = ${factorialRecursiveResult}`);

// Tempo do fatorial iterativo
console.time('iterativo');
const factorialIterativeResult = factorialIterative(n);
console.timeEnd('iterativo');
console.log(`Iterativo: Resultado = ${factorialIterativeResult}`);
