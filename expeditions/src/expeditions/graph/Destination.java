package expeditions.graph;

public enum Destination {
	DENALI,
	MACKENZIE_DELTA,
	NORTHWEST_PASSAGE,
	GREENLAND,
	THINGVELLIR,
	SVALBARD,
	ZAGORSK,
	PUTORANA_PLATEAU,
	SAKHA,
	KOLYMA,
	BERING_STRAIT,
	CRATER_LAKE,
	BANFF,
	OLD_FAITHFUL,
	NIAGARA_FALLS,
	NEWFOUNDLAND,
	STONEHENGE,
	CASPIAN_SEA,
	NOVOSIBIRSK,
	LAKE_BAIKAL,
	AMUR_RIVER,
	GRAND_CANYON,
	LOUISIANA,
	CANARY_ISLANDS,
	TIMGAD,
	ROME,
	ATHENS,
	GIZA,
	PETRA,
	BABYLON,
	PERSEPOLIS,
	HARAPPA,
	MOUNT_EVEREST,
	TAJ_MAHAL,
	XI_AN,
	BAGAN,
	TEOTIHUACAN,
	TIKAL,
	PUERTO_RICO,
	TIMBUKTU,
	SAHARA,
	KUSH,
	AXUM,
	SANAA,
	SIGIRIYA,
	ANGKOR_WAT,
	GALAPAGOS_ISLANDS,
	ANGEL_FALLS,
	MARAJO,
	AMAZON_RAINFOREST,
	PACIFIC_OCEAN,
	MACHU_PICCHU,
	ARIPUANA,
	SALVADOR_DE_BAHIA,
	ALTIPLANO,
	IGUAZU_FALLS,
	ATACAMA,
	RAPA_NUI,
	TIERRA_DEL_FUEGO,
	GRAHAM_LAND,
	ELMINA,
	DOUALA,
	VIRUNGA,
	VICTORIA_FALLS,
	MADAGASKAR,
	OMATAKO,
	ATLANTIC_OCEAN,
	INDIAN_OCEAN,
	SULAWESI,
	BOROBUDUR,
	PAPUA,
	ARNHEM_LAND,
	BUGLE_BUNGLE_RANGE,
	GREAT_BARRIER_REEF,
	ULURU,
	PERTH,
	TASMANIA,
	FIORDLAND_NATIONAL_PARK;
	
	String niceName;
	
	public String niceName() {
		if(niceName != null) return niceName;
		String result = this.name().toLowerCase();
		result = result.substring(0, 1).toUpperCase() + result.substring(1);
		for(int i = 1; i < result.length(); i++) {
			if(result.charAt(i - 1) == '_') {
				result = result.substring(0, i - 1) + " " + result.substring(i - 1, i).toUpperCase() + result.substring(i);
			}
		}
		niceName = result;
		return result;
	}

}
