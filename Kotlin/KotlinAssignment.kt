//Kotling assignment, Kruize Christensen, Due Monday April 5th

data class City (var name: String, val latitude: Double, val longitude: Double)

fun listCities() : 
List<City> {return listOf(
		City("Atlanta", 33.7490, -84.3880), 
        City("Bozeman", 45.6770, -111.0429),
        City("New York", 40.7128, -74.0060),
        City("San Francisco", 37.7749, -122.4194),
        City("Tacoma", 47.2529, -122.4443))}

fun distanceFromSeattle(city: City) : Double {
		return haversine( 47.6062, -122.3321, city.latitude, city.longitude)}

fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
		val R = 6372.8 // in kilometers
		val l1 = Math.toRadians(lat1)
		val l2 = Math.toRadians(lat2)
		val dl = Math.toRadians(lat2 - lat1)
		val dr = Math.toRadians(lon2 - lon1)
		return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(dl / 2), 2.0) + Math.pow(Math.sin(dr / 2), 2.0) * Math.cos(l1) * Math.cos(l2)))
}

fun main() {
 		var cityLocations = listCities()

    	println("**********Step Two**********")
    	val itr = cityLocations.listIterator()
    	while (itr.hasNext()) {
        	println(itr.next())
    	}



    	println("**********Step Three**********")
    	println("The distance between Seattle and Tacoma is " + distanceFromSeattle(City("Tacoma", 47.2529,-122.4443)) + " km" + "\n")



    	println("**********Step Four**********")
    	println("A new list with the distances of all cities in the list to Seattle:\n")
    	println(cityLocations.map { city -> distanceFromSeattle(city) })



    	println("\n" + "**********Step Five**********")
    	println("List of cities over 1000km from Seattle (used the return \nlist from the Filter function and just printed the city \nname)")
    	var distance = cityLocations.filter { city -> distanceFromSeattle(city) > 1000 }

    	for (city in distance) {
        	println(city.name)
}


    	println("\n" + "**********Step Six**********")
    	var western = cityLocations.filter { it -> it.longitude < -89.97803 }.map { it -> it.name }
    	println(western)



    	println("\n" + "**********Step Seven**********")
    	var furthest = cityLocations.maxBy { distanceFromSeattle(it) }
    	println("Max distance: " + furthest + "\n")



    	println("**********Step Eight**********")
    	var mappedCities: Map<String, City> = cityLocations.map { it.name to it }.toMap()
    	mappedCities.forEach{
        	name, city -> println("Name $name: City $city")
    	}
    	var myCity = "Bozeman"
    	if(mappedCities.containsKey(myCity)) {
        	println("The latitude for $myCity is " + mappedCities.getValue(myCity).latitude)
    	}
}
