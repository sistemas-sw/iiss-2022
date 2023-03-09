
# ruby archivo.rb

class Orquesta
    include Enumerable

    def initialize
        @instrumentos = Instrumentos.new(3)
    end
    
    def addInstrumento(i)
        @instrumentos.add(i)
    end
    
    def removeInstrumento(i)
        @instrumentos.remove(i)
    end
    
    def each(&block)
        @instrumentos.each(&block)
    end

    def tocar
        @instrumentos.each { |i| i.tocar unless i.nil? }
      end
    
    def afinar(i)
        i.afinar
        i.tocar
    end
end
    
class Instrumentos
    include Enumerable

    def initialize(numero)
        @instrumentos = Array.new(numero)
    end
    
    def add(i)
        @instrumentos.push(i)
    end
    
    def remove(i)
        @instrumentos.delete(i)
        i
    end
    
    def each(&block)
        @instrumentos.each(&block)
    end
end
    
class Viento
    def tocar
        puts "Tocando instrumento de viento."
    end
    
    def afinar
        puts "Afinando instrumento de viento."
    end
end
    
class Cuerda
    def tocar
        puts "Tocando instrumento de cuerda."
    end
    
    def afinar
        puts "Afinando instrumento de cuerda."
    end
end
    
class Percusion
    def tocar
        puts "Tocando instrumento de percusión."
    end
    
    def afinar
        puts "Afinando instrumento de percusión."
    end
end
    
class PruebaOrquesta
    def self.main

        orquesta = Orquesta.new
        viento = Viento.new
        cuerda = Cuerda.new
        percusion = Percusion.new

        orquesta.addInstrumento(viento)
        orquesta.addInstrumento(cuerda)
        orquesta.addInstrumento(percusion)

        orquesta.each do |i|
            orquesta.afinar(i) unless i.nil?
        end

        orquesta.tocar
    end
end

PruebaOrquesta.main