from cx_Freeze import setup, Executable
import os
os.environ['TCL_LIBRARY'] = "D:\\Roaming\\Python\\Python36\\tcl\\tcl8.6"
os.environ['TK_LIBRARY'] = "D:\\Roaming\\Python\\Python36\\tcl\\tk8.6"

 
setup(
    name = 'Snake',
    options = {'build_exe': {'packages':['pygame'],
                             'include_files': ['Pacifico.ttf',
                                               'Snake.png',                                       
                                               'apple.png',
                                               'apple32x32transparent.png',
                                               'DBZ.wav',
                                               'menu.wav',
                                               'Croc.wav',
                                               'valider.wav',
                                               'Defeat.wav']}},
    description = 'Just a Snake game',
    executables = [Executable('Snake.py')]
    )
