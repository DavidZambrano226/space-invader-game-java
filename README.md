# space-invader-game-java - Proyecto Patrones.

## Descripción

La finalidad de este proyeto es aplicar patrones de diseño de softwar a un codigo ya existente, 
implementando las mejores practicas para pasar de un código poco mantenible y poco escalable
a un codigo facil de mantener y de escalar.

## Patrones implementados

A continuación se relacionan los patrones implementados:

### Patrones Creacionales
 1. Patron Singleton 
 2. **Patron Builder**: Builder permite construir objetos complejos de forma mas legible
 3. Patron Factory Method: Este patron fue implementado para poder crear enemigos 
### Patrones Estructurales
  1. **Facade**: El patron facade (fachada) fue implementado para abstraer la inicialización de todos los hilos del juego.
![facade-class.png](src%2Fmain%2Fresources%2Fdiagrams%2Ffacade-class.png)
  2. **Proxy**: Se implemento el patron proxy para hacer un filtrado entre los eventos emitidos por el usuario desde el Teclado, con el fin de alertar sobre acciones que no se pueden realizar dentro del juego.
![proxy-class.png](src%2Fmain%2Fresources%2Fdiagrams%2Fproxy-class.png)

### Patrones Comportamentales
  1. Strategy
  2. **Command**: Space Invader tiene diferentes comandos, el patron comando permite desacoplar estos comandos para que puedan ser invocados desde diferentes componentes (Eventos de teclado, Botones, etc).
![command-class.png](src%2Fmain%2Fresources%2Fdiagrams%2Fcommand-class.png)
### Patrones de interaccion
  1. **Hover Tools**: Mensaje de ayuda que se muestra al momento de pasar el cursor sobre un elemento. Adicional a ello se observa un cambio de cursor sobre el menu al momento de pasar el cursos sobre los elementos.
![hover-pattern.png](src%2Fmain%2Fresources%2Fdiagrams%2Fhover-pattern.png)
  2. **Prominent "DONE" Button**: Boton de acción como aceptar, confirmar, procesar que sobre salga por encima de los demas para invitar al usuario a hacer click
![prominent-button.png](src%2Fmain%2Fresources%2Fdiagrams%2Fprominent-button.png)
  3. **Input Prompt**: Placeholder que brinda una ayuda visual al usuario para ingresar un texto en un campo tipo input.
![prominent-button.png](src%2Fmain%2Fresources%2Fdiagrams%2Fprominent-button.png)
  4. **Titled Section**: Titulo que sobre sale sobre los otros elementos.
![title-pattern.png](src%2Fmain%2Fresources%2Fdiagrams%2Ftitle-pattern.png)


## Antipatrones

En el código original se identificaron los siguientes Antipatrones: 

1. The blob (mancha)
2. Boat Anchor (Ancla del barco)
3. Lava Flow (Flujo de lava)

## 
