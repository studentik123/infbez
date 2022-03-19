package com.company;


class lab2{



    public static void main(String[] args)
    {
        long P, G, x, a, y, b, kaa, kbb;
        P = 27;
        System.out.println("Значение P:" + P);
        G = 19;
        System.out.println("Значение G:" + G);
        a = 7;
        System.out.println("Приватный ключ Алисы:" + a);
        x = DiffieHellmanpower(G, a, P);
        b = 8;
        System.out.println("Приватный ключ Боба:" + b);
        y = DiffieHellmanpower(G, b, P);
        ka = DiffieHellmanpower(y, a, P);
        kb = DiffieHellmanpower(x, b, P);
        System.out.println("Секретннный ключ Алисы:" + ka);
        System.out.println("Секретный ключ Боба:" + kb);
    }
    private static long DiffieHellmanpower(long a, long b, long p)
    {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
    }
}
