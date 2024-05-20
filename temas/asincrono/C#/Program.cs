class Program
{
    static async Task Main(string[] args)
    {
        Console.WriteLine("------------- Comienza el desayuno síncrono ----------------");
        await DesayunoSíncrono();
        Console.WriteLine("------------- Comienza el desayuno asíncrono ----------------");
        await DesayunoAsync();
    }

    static async Task PrepararCafe()
    {
        Console.WriteLine("Preparando café...");
        await Task.Delay(5000);
        Console.WriteLine("Café Listo...");

    }
    static async Task HacerTostada()
    {
        Console.WriteLine("Haciendo la Tostada...");
        await Task.Delay(2000);
        Console.WriteLine("Tostada Lista...");

    }
    static void PonerLaMesa()
    {
        Console.WriteLine("Poniendo la mesa...");
    }
    static async Task BeberCafe()
    {
        Console.WriteLine("Bebiendo café...");
        await Task.Delay(3000);
        Console.WriteLine("Café acabado...");

    }

    static async Task ComerTostada()
    {
        Console.WriteLine("Comiendo tostada...");
        await Task.Delay(3000);
        Console.WriteLine("Tostada acabada...");

    }

    static async Task DesayunoAsync()
    {
        var tareaPrepararCafe = PrepararCafe();
        var tareaPrepararTostada = HacerTostada();
        await tareaPrepararCafe;
        await tareaPrepararTostada;
        PonerLaMesa();
        var tareaBeberCafe = BeberCafe();
        var tareaComerTostada = ComerTostada();

        await tareaBeberCafe;
        await tareaComerTostada;
        Console.WriteLine("Fin del desayuno asícrono");
    }

    static async Task DesayunoSíncrono()
    {
        await PrepararCafe();
        await HacerTostada();
        PonerLaMesa();
        await BeberCafe();
        await ComerTostada();

        Console.WriteLine("Fin del desayuno síncrono");
    }


}