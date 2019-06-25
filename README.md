# Movalid (Android)

> Aplicación nativa en Android desarrollada para consultar películas y series divididas en 3 categrías: "Popular", "Top Rated" y "Upcoming". Para cada película o serie se muestra su poster, título, sinopsis, fecha y categorías.

> Las películas y series son tomadas de la API "The Movie Database API" (https://developers.themoviedb.org/4/getting-started/authorization)

### Información:
- MVVM
- AndroidStudio 10.2.1
- Kotlin 1.3.21 (JetPack)
- RetroFit 2.4.0
- Navigation 1.0.0
- Glide 4.8.0
- Moshi 1.8.0

## Capturas de pantalla

### Vista principal de la aplicación:
En la parte superior se observa las opciones para visualizar Películas o Series, y de cada una de estas se puede escoger entre las categorías "Popular", "Top Rated" y "Upcoming". Para la opción seleccionada se observa la lista de películas/series que pertenecen a ella.

<img src="./Screenshot/home.png" width="300"> <img src="./Screenshot/homeSerie.png" width="300">

### Vista detallada de una película/serie:
Se muestra toda la información en pantalla completa, su imagen, fecha, categorías, sinopsis y en la parte superior izquierda un ícono de video que permite visualizar su trailer.

<img src="./Screenshot/detail.png" width="300">

### Vista de sección de búsqueda:
A esta sección se ingresa desde el ícono de lupa en la parte superior derecha de la vista principal, y permite la búsqueda de películas y series por medio de texto.

<img src="./Screenshot/search.png" width="300">


## Capas de la aplicación

### Capa de persistencia

Movie.kt	
ResponseApi.kt
HomeViewModel.kt

### Capa de Vista
HomeFragment.kt
home_fragment.xml

### Capa de Red
PostApi.kt

## Responsabilidad de las clases

Movie.kt	
ResponseApi.kt = Representacion de la respuesta generica del WebService que contiene una lista de Movie
HomeViewModel.kt = ViewModel al que se conecta el HomeFragment

HomeFragment.kt = Fragment principal 
home_fragment.xml 

PostApi.kt = Encargado de realizar las peticiones por medio de RetroFit

