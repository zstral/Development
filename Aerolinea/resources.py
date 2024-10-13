import numpy as np
mainMenu = {
    1: "Consultar disponibilidad de asiento",
    2: "Reservar asiento",
    3: "Anular vuelo",
    4: "Actualizar información de pasajero",
    0: "Salir"
}

subMenu = {
    1: "Nombre",
    2: "Teléfono",
    3: "Volver"
}

seats = np.arange (1, 49, dtype=object).reshape(8, 6)

reg = []

def addUser(name, rut, tel, bank, seat, totPrice):
    dictUser = {
        "Nombre" : name,
        "RUT" : rut,
        "Teléfono" : tel,
        "Banco" : bank,
        "Asiento" : seat,
        "Precio" : totPrice
    }
    reg.append(dictUser)