# space-invader-game-java - Proyecto Patrones.

## Descripción

La finalidad de este proyeto es aplicar patrones de diseño de softwar a un codigo ya existente, 
implementando las mejores practicas para pasar de un código poco mantenible y poco escalable
a un codigo facil de mantener y de escalar.

## Patrones implementados

A continuación se relacionan los patrones implementados:

### Patrones Creacionales
 1. Patron Singleton 
 2. Patron Builder
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
  1. Hover Tools
  2. Prominent "DONE" Button 
  3. Input Prompt
  4. Titled Section


## Antipatrones

En el código original se identificaron los siguientes Antipatrones: 

1. The blob (mancha)
2. Boat Anchor (Ancla del barco)
3. Lava Flow (Flujo de lava)

## 
