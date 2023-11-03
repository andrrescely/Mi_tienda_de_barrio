package model;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<Producto> leerProductosDesdeExcel(String filePath) {
        List<Producto> productos = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String nombre = row.getCell(0).getStringCellValue();
                String descripcion = row.getCell(1).getStringCellValue();
                String categoriaStr = row.getCell(2).getStringCellValue();
                Categoria categoria = Categoria.fromString(categoriaStr.toUpperCase());
                String etiquetas = row.getCell(3).getStringCellValue();
                String precioString = row.getCell(4).getCellType() == CellType.STRING ?
                        row.getCell(4).getStringCellValue() :
                        String.valueOf(row.getCell(4).getNumericCellValue());

                double precio;
                try {
                    precio = Double.parseDouble(precioString);
                } catch (NumberFormatException e) {
                    precio = 0.0; // Valor por defecto si no se puede convertir
                }

                int cantidad = 0;
                if (row.getCell(5).getCellType() == CellType.NUMERIC) {
                    cantidad = (int) row.getCell(5).getNumericCellValue();
                }

                Producto producto = new Producto(nombre, descripcion, categoria, etiquetas, precio, cantidad);
                productos.add(producto);
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;
    }
}
