package model;
public enum Categoria {
    ASEO_HOGAR,
    BEBIDAS,
    CARNES_FRIAS_CONGELADOS,
    CIGARRILLOS,
    CUIDADO_BEBE,
    CUIDADO_PERSONAL,
    CUIDADO_ROPA,
    DESPENSA,
    DROGERIA,
    DULCES_POSTRES,
    ELECTRODOMESTICOS,
    HELADOS,
    HOGAR_DECORACION,
    ILUMINACION_ELECTRICOS,
    LACTEO_HUEVOS_REFRIGERADOS,
    LIMPIEZA_COCINA,
    MASCOTAS,
    PANADERIA_PASTELERIA,
    PASABOCAS,
    VINOS_LICORES,
    // Nuevas categorías de mi Excel
    ASEO_HOGAR_EXCEL,
    BEBIDAS_EXCEL,
    CARNES_FRIAS_CONGELADOS_EXCEL,
    CIGARRILLOS_EXCEL,
    CUIDADO_BEBE_EXCEL,
    CUIDADO_PERSONAL_EXCEL,
    CUIDADO_ROPA_EXCEL,
    DESPENSA_EXCEL,
    DROGERIA_EXCEL,
    DULCES_POSTRES_EXCEL,
    ELECTRODOMESTICOS_EXCEL,
    HELADOS_EXCEL,
    HOGAR_DECORACION_EXCEL,
    ILUMINACION_ELECTRICOS_EXCEL,
    LACTEO_HUEVOS_REFRIGERADOS_EXCEL,
    LIMPIEZA_COCINA_EXCEL,
    MASCOTAS_EXCEL,
    PANADERIA_PASTELERIA_EXCEL,
    PASABOCAS_EXCEL,
    VINOS_LICORES_EXCEL,
    OTRA_CATEGORIA; // Si nno coincide

    // Método para convertir una cadena a una constante de la enumeración
    public static Categoria fromString(String categoriaStr) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.toString().equalsIgnoreCase(categoriaStr)) {
                return categoria;
            }
        }// si no se encuentra una coincidencia
        return OTRA_CATEGORIA;
    }
}



