import time

# Fatorial Recursivo
def factorial_recursive(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial_recursive(n - 1)

# Fatorial Iterativo
def factorial_iterative(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

# Teste de desempenho
n = 30

# Tempo do fatorial recursivo
start_time = time.time()
factorial_recursive_result = factorial_recursive(n)
end_time = time.time()
recursive_time = end_time - start_time
print(f"Recursivo: Resultado = {factorial_recursive_result}, Tempo = {recursive_time} segundos")

# Tempo do fatorial iterativo
start_time = time.time()
factorial_iterative_result = factorial_iterative(n)
end_time = time.time()
iterative_time = end_time - start_time
print(f"Iterativo: Resultado = {factorial_iterative_result}, Tempo = {iterative_time} segundos")
