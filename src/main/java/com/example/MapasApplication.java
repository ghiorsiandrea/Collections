package com.example;

import com.example.map.MyMapImpl1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class MapasApplication{

	private static SimpleDateFormat STRING_TO_DATE = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(MapasApplication.class, args);

		HashMap<String, Date> fechasImportantes=new HashMap<String, Date>();

		fechasImportantes.put("El dia en que hicimos Match en Tinder", STRING_TO_DATE.parse("02-02-2018"));
		fechasImportantes.put("El dia en que hicimos el amor", STRING_TO_DATE.parse("26-02-2018"));
		System.out.println("\n" + fechasImportantes);
		fechasImportantes.remove("El dia en que hicimos Match en Tinder");
		System.out.println("\n" + fechasImportantes);

		//MapsAyM A = new MapsAyM<>();

		MyMapImpl1 p = new MyMapImpl1();

		//MapsAyM.Prueba2 prueba2 = A.new Prueba2();
	}

}
