#Autor: Jisela Londoño Herrera

  Feature: Reservacion hotel
    As
    I
    To

  Scenario Outline: Prueba1
  Given Jisela quiere hacer uso del servicio de reservas de <prueba> presente en Travelocity
  #When ella elige de manera adicional los servicios de
  #Vuelos
  #And ella indica completamente la información en la que está interesada buscar
  #Origen
  #Bogota
  #And reserva la habitación Twin Room Standard (opción Free cancellation) del hotel Estelar Square
  #And elige el vuelo de salida con prioridad de precio (menor)
  #And elige el vuelo de regreso con prioridad de precio (menor)
  #Then se debe presentar un resumen con la información de los vuelos y hotel elegidos

  Examples:
    |prueba|
    |Hotels|
    |Flights|
    |Cars   |
    |Packages|
    |Things to do|
    |Cruises     |