# Ejemplo de lambda en Ruby
lambda_generic = ->(x, y) { x + y }
puts "Resultado de lambda en Ruby: #{lambda_generic.call(3, 5)}"

# Ejemplo de lambda con múltiples líneas en Ruby
lambda_multiline = lambda do |x, y|
  sum = x + y
  product = x * y
  "Suma: #{sum}, Producto: #{product}"
end
puts lambda_multiline.call(3, 5)
