import re
from resources import seats, reg, addUser, subMenu

#Verificación de entradas
def printMenu(menu):
    print ("")
    for k, v in menu.items():
        print (f"{k} - {v}")

def options():
    while True:
        opt = input("\nIngrese una opción: ").strip()
        if verification(opt):
            return int(opt)
        else:
            print("Por favor, ingrese una opción válida")

def verification(opt):
    try:
        return int(opt) in [0, 1, 2, 3, 4, 5]
    except ValueError:
        return False

def calcDV(num: str) -> str:
    sum = 0
    mul = 2
    i = len(num)
    while i > 0:
        i -= 1
        sum += int(num[i]) * mul
        if mul % 7 == 0:
            mul = 2
        else:
            mul += 1
    res = sum % 11
    if res == 0:
        return '0'
    elif res == 1:
        return 'k'
    return str(11 - res)

def prices(row, column):
    if column in [0, 2, 3, 5]:
        return 250000
    elif column in [1, 4]:
        return 170300
    
def calcDesc(bank, price):
    if bank == "bancoduoc":
        desc = price * 0.88
        print(f"Descuento del 12% aplicado por pertenecer a BancoDuoc.\nPrecio final: {desc:.0f} pesos.")
        return desc
    else:
        return price
#------------------------------------------------------------------------

#Funciones de uso general
def availability():
    print ("---Asientos disponibles---\n_____________________")
    for i, row in enumerate(seats):
        print("|", " ".join(f"{num:2}" for num in row), "|")
        print("         ")
        if i == 4:
            print("   |_____________\n   _____________|")
            print("   |_____________\n                |")
    print("- Precio Ventana y Pasillo: $250.000\n- General (Entremedio de Ventana y Pasillo): $170.300")
    input("\nPresione enter para volver al menú")    
    
def reserve():
    print ("\n---Reserva de Asientos---")
    while True:
        name = input("Ingrese su nombre completo: ").strip()
        if re.match(r'^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$', name):
            break
        else:
            print("El formato no es válido.\nDebe contener tener al menos dos caracteres y no se permiten carácteres especiales.")  
    while True:
        rut = input("Ingrese RUT sin puntos. (Ejemplo: 12345678-9):").strip().lower()
        if re.match(r'^\d{7,8}-[0-9kK]$', rut):
            rut, dv = rut.split('-')
            dvVerified = calcDV(rut)
            if dv == dvVerified:
                print("RUT Válido.")
                break
            else:
                print(f"RUT inválido. Ingrese un RUT válido.")
        else:
            print("RUT inválido. Debe seguir el formato '12345678-9' o '12345678-k'.")
    while True:
        tel = input("Ingrese número de teléfono (9 dígitos): ").strip()
        if re.match(r'^\d{9}$', tel):
            break
        else:
            print("Formato inválido. Debe contener 9 dígitos.")
    while True:
        bank = input("Ingrese el nombre de la entidad bancaria: ").strip().lower()
        if bank:
            break
        else:
            print("Este campo no puede estar vacío, ingrese el nombre de la entidad bancaria.")
    while True:
        try:
            seat = int(input("Ingrese el número de asiento: "))
            if seat < 1 or seat > 48:
                print("Número de asiento no válido. Ingrese un número entre 1 y 48.")
                continue
            else:
                row = (seat - 1) // 6
                column = (seat - 1) % 6
            if seats[row][column] == "X":
                print(f"El asiento {seat} ya está reservado.")
                continue
            else:
                seats[row][column] = "X"
                price = prices(row, column)
                totPrice = calcDesc(bank, price)
                print(f"Asiento {seat} reservado exitosamente.")
                break
        except ValueError:
            print("Entrada no válida. Ingrese un número entero.")
    addUser(name, rut, tel, bank, seat, totPrice)

def regDelete(): 
    print("---Anular vuelo---\n")
    print("! ATENCIÓN ! - Esta operación elimina el registro completo asociado a un vuelo y no se puede deshacer - ! ATENCIÓN !\n")
    rut = input("Ingrese RUT: ").strip().upper()
    found = False
    for user in reg:
        if user['RUT'] == rut:
            found = True
            print(f"Se encontró el RUT registrado: {user['RUT']} - Asiento:{user['Asiento']}")
            confirm = input("Desea borrar el registro? (s/n): ").lower()
            if confirm == "s":
                reg.remove(user)
                seat = user['Asiento']
                row = (seat - 1) // 6
                column = (seat - 1) % 6
                seats[row][column] = f"{seat:2}"
                print("\n*** Borrado con exito. ***\n")
                break
            elif confirm == "n":
                print("\n*** Se canceló borrar. ***\n")
                break
            else:
                print("Por favor, ingrese 's' o 'n'.")
        if not found:  
            print("\n[!] No se encontró el RUT registrado. [!]\n")
    
def regUpdate():
    print("---Actualizar datos de usuario---\n")
    rut = input("Ingrese RUT sin dígito verificador (Ejemplo: 12345678): ").strip().upper()
    found = False
    for user in reg:
        if user['RUT'] == rut:
            print(f"Se encontró el RUT registrado: {user['RUT']} - Asiento:{user['Asiento']}\n")
            found = True
            while True:
                print("Ingrese una opción para modificar:\n")
                printMenu(subMenu)
                opt = options()
                if opt == 1:
                    newName = input("Ingrese nuevo nombre: ").strip().capitalize()
                    if re.match(r'^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$', newName):
                        user['Nombre'] = newName
                        print("Actualizado con éxito.")
                        break
                    else:
                        print("El formato no es válido.\nDebe contener tener al menos dos caracteres y no se permiten carácteres especiales.")  
                elif opt == 2:
                    newTel = input("Ingrese nuevo número de teléfono: ").strip()
                    if re.match(r'^\d{9}$', newTel):
                        user['Teléfono'] = newTel
                        print ("Actualizado con éxito.")
                        break
                    else:
                        print("Formato inválido. Debe contener 9 dígitos.")
                elif opt == 3:
                    return
            if not found:
                print("\n[!] No se encontró el RUT registrado. [!]\n")
                 
def goodbye():
    print ("Hasta pronto.\nVersión 0.1\nCreado por: Rafael Fernández")