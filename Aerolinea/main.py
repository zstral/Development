from core import printMenu, options, availability, reserve, regDelete, regUpdate, goodbye
from resources import mainMenu

while True:
    printMenu(mainMenu)
    option = options()
    if option == 1:
        availability()
    elif option == 2:
        reserve()
    elif option == 3:
        regDelete()
    elif option == 4:
        regUpdate()
    elif option == 0:
        goodbye()
        break
    else:
        print ("Por favor, seleccione una opción válida")