import pygame as py
import time
import random

py.init()


# Constantes

display_width = 800
display_height = 600
block_size = 20
appleThickness = 30
FPS = 10
direction = 'right'
clock = py.time.Clock()



# Couleurs
white = (255,255,255)
black = (0,0,0)
green = (22,184,78)
red = (255,0,0)
blue = (119, 181,254)

lightGreen = (0,255,0)
darkGreen = (31,160,85)

darkRed = (207,10,29)
lightRed = (254,27,0)

darkYellow = (200,200,0)
lightYellow = (255,255,0)

# Fonts
smallfont = py.font.Font('./Font/Pacifico.ttf', 25)
medfont = py.font.Font('./Font/Pacifico.ttf', 40)
largefont = py.font.Font('./Font/Pacifico.ttf', 100)

# Images
img = py.image.load('./Images/Snake.png')
imgApple = py.image.load('./Images/apple.png')
imgBigApple = py.image.load('./Images/appleTransparent.png')
icone = py.image.load('./Images/apple32x32transparent.png')

# Sons

son = py.mixer.Sound('./Music/DBZ.wav')
sonMenu = py.mixer.Sound('./Music/menu.wav')
sonCroc = py.mixer.Sound('./Music/Croc.wav')
sonValider = py.mixer.Sound('./Music/valider.wav')
sonDefeat = py.mixer.Sound('./Music/Defeat.wav')
sonQuick = py.mixer.Sound('./Music/quick.wav')

son.set_volume(0.03)
sonMenu.set_volume(0.1)
sonCroc.set_volume(0.05)
sonValider.set_volume(0.2)
sonDefeat.set_volume(0.5)
sonQuick.set_volume(0.5)

sonOn = True


# Création fenêtre
gameDisplay = py.display.set_mode((display_width,display_height))
py.display.set_icon(icone)
py.display.set_caption('Snake')


# Intro du jeu
def game_intro():
    sonMenu.play(loops =-1)
    gameVersion = smallfont.render('Game Version : 1.1.0', True, red)
    intro = True

    while intro:
        
        for event in py.event.get():
            if event.type == py.QUIT:
                py.quit()
                quit()
            if event.type == py.KEYDOWN:
                if event.key == py.K_c:
                    intro = False
                    sonValider.play()
                    time.sleep(1)
                if event.key == py.K_q:
                    py.quit()
                    quit()
        
        gameDisplay.fill(blue)
        message_on_screen('Snake',
                          green,
                          -150,
                          'large')
        message_on_screen('Just eat the apples and get stronger bro',
                          black,
                          -20,
                          'small')
        message_on_screen('But don\'t bite yourself or go off the screen',
                          black,
                          30,
                          'small')
        message_on_screen('Good Luck !',
                          black,
                          90,
                          'small')
        
        gameDisplay.blit(gameVersion, [display_width - 225, display_height - 50])
        gameDisplay.blit(imgBigApple,[display_width-235 , display_height-525])
        gameDisplay.blit(imgBigApple,[display_width-700 , display_height-525])

        button('Play', 150, 450, 100, 50, darkGreen, lightGreen, action='play')
        button('Controls', 350, 450, 100, 50, darkYellow, lightYellow, action='controls')
        button('Quit',550, 450, 100, 50, darkRed, lightRed, action='quit')
        
        
        py.display.update()
        clock.tick(10)


# Fonction qui dessine le snake        
def snake (block_size, snakeList):

    if direction == 'right':
        head = py.transform.rotate(img, 270)
    elif direction == 'left':
        head = py.transform.rotate(img, 90)
    elif direction == 'up':
        head = img
    elif direction == 'down':
        head = py.transform.rotate(img, 180)

    gameDisplay.blit(head, (snakeList[-1][0], snakeList[-1][1]))
    
    for XnY in snakeList[:-1]:
        py.draw.rect(gameDisplay, green, [XnY[0],XnY[1], block_size, block_size])

# Fonction qui permet la pause
def pause():

    pause = True
    message_on_screen('Pause',
                        green,
                        -100,
                        'large')
    
    message_on_screen('Press C to resume',
                        black,
                        50,
                        'med')

    
    
    

    while pause:

        #button('Play', 250, 450, 100, 50, darkGreen, lightGreen, action='pause')
        button('Quit', 350, 450, 100, 50, darkRed, lightRed, action='quit')            
        
        for event in py.event.get():
            if event.type == py.QUIT:
                py.quit()
                quit()

            if event.type == py.KEYDOWN:
                if event.key == py.K_c:
                    pause = False

                elif event.key == py.K_q:
                    py.quit()
                    quit()

        #gameDisplay.fill(blue)
        py.display.update()
        clock.tick(30)

# Fonction qui crée un bouton où on veut sur l'écran

def button(text, x, y, width, height, inactiveColor, activeColor, action = None):

    global pause
    global sonOn
    cur = py.mouse.get_pos()
    click = py.mouse.get_pressed()
    
    if x + width > cur[0] > x and y + height > cur[1] > y:
        #sonQuick.play()
        py.draw.rect(gameDisplay, activeColor, (x,y,width,height))
        
        if click[0] == 1 and action != None:
            if action == 'quit':
                py.quit()
                quit()
            if action == 'controls':
                message_on_screen('Arrow keys to move, that\'s all :)',
                          black,
                          230,
                          'small')
            if action == 'play':
                sonValider.play()
                time.sleep(1)
                gameLoop()
            if action == 'replay':
                sonOn = False
                sonValider.play()
                time.sleep(1)
                gameLoop()


                
    else: 
        py.draw.rect(gameDisplay, inactiveColor, (x,y,width,height))

    text_to_button(text, black, x,y,width,height)

# Fonction qui affiche le score 
def score(score):
    text = smallfont.render('Score: '+str(score), True, black)
    gameDisplay.blit(text, [0,0])

# Fonction qui génère les coordonnées de la pomme
def appleGen():
    randAppleX = round(random.randrange(0, display_width-appleThickness))
    randAppleY = round(random.randrange(0, display_height-appleThickness))

    return randAppleX, randAppleY


# Fonction qui dessine la pomme    
def apple(randAppleX, randAppleY):
    
    gameDisplay.blit(imgApple, (randAppleX, randAppleY))

# Fonction qui met le texte voulu dans un bouton créé au préalable

def text_to_button(msg, color, buttonX, buttonY, buttonWidth, buttonHeight,size = 'small'):
    textSurf, textRect = text_objects(msg, color, size)
    textRect.center = ((buttonX + (buttonWidth/2)), buttonY+(buttonHeight/2))
    gameDisplay.blit(textSurf, textRect)

# Fonction qui définit la font
def text_objects(msg, color, size):
    if size == 'small':      
        textSurface = smallfont.render(msg, True, color)
    elif size == 'med':
        textSurface = medfont.render(msg, True, color)
    elif size == 'large':
        textSurface = largefont.render(msg, True, color)
    return textSurface, textSurface.get_rect()


# Fonction qui affiche un message à l'écran (centré en x)    
def message_on_screen(msg, color, y_displace = 0, size = 'small'):

    textSurf, textRect = text_objects(msg, color, size)
    textRect.center = (display_width/2), (display_height/2)+ y_displace
    gameDisplay.blit(textSurf, textRect)

# Boucle de jeu principale    
def gameLoop():
    
    sonMenu.stop()
    global sonOn
    global direction
    direction = 'right'
    gameExit = False
    gameOver = False
    head_x = display_width/2
    head_x_change = 20
    head_y = display_height/2
    head_y_change = 0

    snakeList = []
    snakeLength = 1

    randAppleX, randAppleY = appleGen()

    if sonOn: # On ne joue la musique que la première fois, pas quand on recommence la boucle après un gameOver
        son.play(loops = -1)

    while not gameExit: # Début de la boucle

        if gameOver:

            message_on_screen('Game Over',
                              red,
                              -50,
                              'large')

            message_on_screen('Your Score: '+str((snakeLength)-1),
                              black,
                              75,
                              'med')

            #button('Replay', 250, 450, 100, 50, darkGreen, lightGreen, action='replay')
            #button('Quit', 450, 450, 100, 50, darkRed, lightRed, action='quit')
            

            
            
            
        while gameOver:  #Quand on perd
            
            button('Replay', 250, 450, 100, 50, darkGreen, lightGreen, action='replay')
            button('Quit', 450, 450, 100, 50, darkRed, lightRed, action='quit')            

            
            # Evenements durant le gameOver
            for event in py.event.get():
                if event.type == py.QUIT:
                    gameExit = True
                    gameOver = False
                #if event.type == py.KEYDOWN:
                    #if event.key == py.K_q:
                        #gameExit = True
                        #gameOver = False
                    #elif event.key == py.K_c:
                        #sonOn = False # Pour éviter de rejouer la musique en appelant gameLoop()
                        #gameLoop()
            py.display.update()
                        
        # Evenements durant le jeu                
        for event in py.event.get():
            if event.type == py.QUIT:
                gameExit = True
            elif event.type == py.KEYDOWN:
                if event.key == py.K_p:
                    pause()
                elif event.key == py.K_LEFT:
                    head_x_change = -block_size
                    head_y_change = 0
                    direction = 'left'
                elif event.key == py.K_RIGHT:
                    head_x_change = block_size
                    head_y_change = 0
                    direction = 'right'
                elif event.key == py.K_UP:
                    head_y_change = -block_size
                    head_x_change = 0
                    direction = 'up'
                elif event.key == py.K_DOWN:
                    head_y_change = block_size
                    head_x_change = 0
                    direction = 'down'

                    
        # gameOver si on sort de la fenetre            
        if head_x >= display_width or head_x < 0 or head_y >= display_height or head_y < 0:
            sonDefeat.play()
            gameOver = True
            
         
        
        
    
        gameDisplay.fill(blue)

        # On génère la pomme
        apple(randAppleX,randAppleY)

        head_x += head_x_change
        head_y += head_y_change
        snakeHead = []
        snakeHead.append(head_x)
        snakeHead.append(head_y)
        snakeList.append(snakeHead)

        # On supprime la queue du snake à chaque boucle
        if len(snakeList)> snakeLength:
            del snakeList[0]

        # gameOver si on se mord la queue :3
        for eachSegment in snakeList[:-1]:
            if eachSegment == snakeHead:
                sonDefeat.play()
                gameOver = True
                
        # On dessine le snake        
        snake(block_size, snakeList)

        # On affiche le score
        score(snakeLength-1)
        
        py.display.update()


        # Block qui gère la collision entre le snake et la pomme
        if head_x > randAppleX and head_x < randAppleX + appleThickness or head_x + block_size > randAppleX and head_x + block_size < randAppleX + appleThickness:
            if head_y > randAppleY and head_y < randAppleY + appleThickness:
                    sonCroc.play()
                    randAppleX, randAppleY = appleGen()
                    snakeLength +=1
                    
            if head_y + block_size > randAppleY and head_y + block_size < randAppleY + appleThickness:
                    sonCroc.play()
                    randAppleX, randAppleY = appleGen()
                    snakeLength +=1
            
        clock.tick(FPS)
    
    
    
    py.quit()
    quit()
        
game_intro()
gameLoop()


