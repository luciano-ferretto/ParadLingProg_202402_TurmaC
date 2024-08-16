#Sem parâmetros
greet = lambda: "Hello, World!"
print(greet())  # Saída: Hello, World!

#Com um parâmetro
square = lambda x: x * x
print(square(5))  # Saída: 25

#Com múltiplos parâmetros
add = lambda x, y: x + y
print(add(3, 4))  # Saída: 7

#Passando como parâmetro para uma Função de Ordem Superior
numbers = [1, 2, 3, 4]
doubled = list(map(lambda x: x * 2, numbers))
print(doubled)  # Saída: [2, 4, 6, 8]


