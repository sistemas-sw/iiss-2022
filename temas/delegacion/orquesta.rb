
// scalac NombredelArchivo.scala
// scala NombredelArchivo

// ruby archivo.rb


module Orquesta
    extend Enumerable
    delegate :each, :to_a, :<<, :delete, to: :instrumentos
  
    def initialize
        @instrumentos = []
    end

    def tocar
        each(&:tocar)
    end
  
    def afinar(i)
        i.afinar
        i.tocar # Prueba de que está afinado
    end
end
  
class PruebaOrquesta
    def self.main
        orquesta = Object.new.extend(Orquesta)
        orquesta << Viento.new
        orquesta << Cuerda.new
        orquesta << Percusion.new
  
        orquesta.each { |i| orquesta.afinar(i) }
        orquesta.tocar
    end
end
  