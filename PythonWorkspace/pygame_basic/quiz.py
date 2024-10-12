# Quiz) 하늘에서 떨어지는 똥 피하기 게임을 만드시오

# [게임 조건]
# 1. 캐릭터는 화면 가장 아래에 위치, 좌우로만 이동 가능
# 2. 똥은 화면 가장 위에서 떨어짐. x 좌표는 매번 랜덤으로 설정
# 3. 캐릭터가 똥을 피하면 다음 똥이 다시 떨어짐
# 4. 캐릭터가 똥과 충돌하면 게임 종료
# 5. FPS는 30 으로 고정

# [게임 이미지]
# 1. 배경 : 640 * 480 (세로 가로) - background.png
# 2. 캐릭터 : 70 * 70 - character.png
# 3. 똥 : 70 * 70 - enemy.png
import random
import pygame

pygame.init()

screen_width = 480
screen_height = 640
screen = pygame.display.set_mode((screen_width, screen_height))

pygame.display.set_caption("똥 피하기")

clock = pygame.time.Clock()

background = pygame.image.load("C:/Users/sksk0/Desktop/project/PythonWorkspace/pygame_basic/backgroundimg.png")
character = pygame.image.load("C:/Users/sksk0/Desktop/project/PythonWorkspace/pygame_basic/puppy.png")
ddong = pygame.image.load("C:/Users/sksk0/Desktop/project/PythonWorkspace/pygame_basic/ddong.png")

character_size = character.get_rect().size
character_width = character_size[0]
character_height = character_size[1]
character_x_pos = (screen_width / 2) - (character_width / 2)
character_y_pos = screen_height - character_height

to_x = 0

character_speed = 10

ddong_size = ddong.get_rect().size
ddong_width = ddong_size[0]
ddong_height = ddong_size[1]
ddong_x_pos = random.randint(0, screen_width - ddong_width)
ddong_y_pos = 0

ddong_speed = 5

game_font = pygame.font.Font(None, 40)

total_time = 10

start_ticks = pygame.time.get_ticks()

running = True
while running:
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                to_x -= character_speed
            elif event.key == pygame.K_RIGHT:
                to_x += character_speed
        
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                to_x = 0
    
    character_x_pos += to_x 

    ddong_y_pos += ddong_speed

    if character_x_pos < 0:
        character_x_pos = 0
    elif character_x_pos > screen_width - character_width:
        character_x_pos = screen_width - character_width
    
    if ddong_y_pos > screen_height:
        ddong_y_pos = 0
        ddong_x_pos = random.randint(0, screen_width - ddong_width)
    
    character_rect = character.get_rect()
    character_rect.left = character_x_pos
    character_rect.top = character_y_pos

    ddong_rect = ddong.get_rect()
    ddong_rect.left = ddong_x_pos
    ddong_rect.top = ddong_y_pos

    if character_rect.colliderect(ddong_rect):
        print("맞았어요")
        running = False 

    screen.blit(background, (0, 0))
    screen.blit(character, (character_x_pos, character_y_pos))
    screen.blit(ddong, (ddong_x_pos, ddong_y_pos))

    elapsed_time = (pygame.time.get_ticks() - start_ticks) / 1000

    timer = game_font.render(str(int(total_time - elapsed_time)), True, (107, 153, 0))

    screen.blit(timer, (10, 10))

    if total_time - elapsed_time <= 0:
        print("성공")
        running = False

    pygame.display.update()

pygame.quit()    