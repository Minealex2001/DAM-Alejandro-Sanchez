package ejercicio2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {

  public static void main(String[] args) {
    // Primero leemos el archivo CSV y convertimos los datos en una lista que contiene los elementos de nuestro catálogo.
    List<CatalogItem> catalog = Helper.readFileIntoList();

    // Una vez cargado el catálogo, barajamos aleatoriamente los elementos.
    Collections.shuffle(catalog);

    // Le echamos un vistazo a los datos
    Helper.printCatalog(catalog);

    Collections.sort(catalog);

    Helper.printCatalog(catalog);

    Collections.sort(catalog, new PriceComparator());

    Helper.printCatalog(catalog);

    Collections.sort(catalog, new CategoryPriceComparator());

    Helper.printCatalog(catalog);

    Collections.sort(
      catalog,
      new Comparator<CatalogItem>() {
        @Override
        public int compare(CatalogItem o1, CatalogItem o2) {
          int resultado = o1.getCategory().compareTo(o2.getCategory());
          if (resultado == 0) {
            resultado = o1.getPrice().compareTo(o2.getPrice());
          }
          return resultado;
        }
      }
    );

    Helper.printCatalog(catalog);

    Collections.sort(
      catalog,
      (o1, o2) -> {
        int resultado = o1.getCategory().compareTo(o2.getCategory());
        if (resultado == 0) {
          resultado = o1.getPrice().compareTo(o2.getPrice());
        }
        return resultado;
      }
    );
  }
}
