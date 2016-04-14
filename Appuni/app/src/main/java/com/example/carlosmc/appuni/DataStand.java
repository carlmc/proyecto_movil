package com.example.carlosmc.appuni;


import java.util.ArrayList;
import java.util.List;

public class DataStand {
    static List STANDS = new ArrayList<BuildingStand>();
    static {
        STANDS.add(new BuildingStand("Librería Crisol",R.drawable.ic_launcher,"LC"));
        STANDS.add(new BuildingStand("Librería Libun",R.drawable.ic_launcher,"LL"));
        STANDS.add(new BuildingStand("Librería Arcadia",R.drawable.ic_launcher,"LA"));
        STANDS.add(new BuildingStand("Distribuidora Heraldos Negros",R.drawable.ic_launcher,"DHN"));
        STANDS.add(new BuildingStand("Pontificia Universidad Católica del Perú",R.drawable.ic_launcher,"PUCP"));
        STANDS.add(new BuildingStand("Fondo de Cultura Económica",R.drawable.ic_launcher,"FCE"));
        STANDS.add(new BuildingStand("Librería La Familia",R.drawable.ic_launcher,"LLF"));
        STANDS.add(new BuildingStand("Editora Macro EIRL",R.drawable.ic_launcher,"EIRL"));
        STANDS.add(new BuildingStand("Corporativo V y T",R.drawable.ic_launcher,"CVT"));
        STANDS.add(new BuildingStand("CDMA TECH SAC",R.drawable.ic_launcher,"CDMA"));
        STANDS.add(new BuildingStand("Editorial Reverte S.A.",R.drawable.ic_launcher,"ERSA"));
        STANDS.add(new BuildingStand("Ediciones Orem",R.drawable.ic_launcher,"EO"));
        STANDS.add(new BuildingStand("Sociedad San Pablo",R.drawable.ic_launcher,"SSP"));
        STANDS.add(new BuildingStand("Universidad Inca Garcilazo de la Vega",R.drawable.ic_launcher,"UIGV"));
        STANDS.add(new BuildingStand("Oficina Nacional de Procesos Electorales",R.drawable.ic_launcher,"ONPE"));
        STANDS.add(new BuildingStand("San Cristobal",R.drawable.ic_launcher,"SC"));
        STANDS.add(new BuildingStand("Editorial EDUNI",R.drawable.ic_launcher,"EDUNI"));

    }
}
