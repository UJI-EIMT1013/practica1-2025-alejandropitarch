package practica1;

import java.util.*;

import static java.lang.Math.sqrt;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> vistos = new HashSet<>(), resultado = new HashSet<>();
        while (it.hasNext()) {
            int iIni = it.next();
            if (iIni != 0){
                Iterator<Integer> itVistos = vistos.iterator();

                while (itVistos.hasNext()) {
                    int visto = itVistos.next();
                    if (visto % iIni == 0) {
                        resultado.add(visto);
                    } else if (iIni % visto == 0) {
                        resultado.add(iIni);
                    }
                } vistos.add(iIni);
            }
        }
        return resultado;
    }

    //EJERCICIO 2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> nuevosCuadrados = new HashSet<>();
        for (int elem : cuadrados) {
            int cuadrado = elem*elem;
            if(cuadrados.contains(cuadrado) && cuadrado != elem) {
                nuevosCuadrados.add(cuadrado);
            }
            if(noCuadrados.contains(cuadrado)){
                nuevosCuadrados.add(cuadrado);
            }
        }
        for (int elem : noCuadrados) {
            int cuadrado = elem*elem;
            if(cuadrados.contains(cuadrado)) {
                nuevosCuadrados.add(cuadrado);
            }
            if(noCuadrados.contains(cuadrado) && cuadrado != elem){
                nuevosCuadrados.add(cuadrado);
            }
        }

        noCuadrados.addAll(cuadrados);
        Iterator<Integer> it = noCuadrados.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (nuevosCuadrados.contains(i))
                it.remove();
        }
        cuadrados.clear();
        cuadrados.addAll(nuevosCuadrados);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        Collection<Set<T>> col = new ArrayList<>();
        while (it.hasNext()) {
            boolean contenido = false;
            T elem = it.next();
            Iterator<Set<T>> itCol = col.iterator();
            while (itCol.hasNext()) {
                Set<T> s = itCol.next();
                if (!s.contains(elem) && !contenido) {
                    s.add(elem);
                    contenido = true;
                }
            }
            if (!contenido) {
                Set<T> s = new HashSet<>();
                s.add(elem);
                col.add(s);
            }
        }


        return col;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}