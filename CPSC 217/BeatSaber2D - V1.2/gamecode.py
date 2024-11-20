# Ethan Stirling #30229189
# Program: Design a 2D rhythm game that uses arrow keys and WASD keys to hit beats that fall from the top of the screen.
# Date: 2024-04-13

from SimpleGame.simplegame import *
import sys

# Constants
BEAT_DIRECTIONS = ['up', 'down', 'left', 'right']
WASD_TO_ARROW = {'w': 'up', 'a': 'left', 's': 'down', 'd': 'right'}
WASD = ['w', 'a', 's', 'd']
SONGS = ['believer', 'cake by the ocean', 'shut up and dance', 'thunder']
DIFFICULTIES = ['Easy', 'Medium', 'Hard', 'Expert']
VISIBLE = 'visible'
SPEED = 5   # DO NOT CHANGE

# Prompt the user to enter song name, difficulty, and name for the top scores before starting the game
if len(sys.argv) < 4:
    print('Usage: python <file> <name> <song> <difficulty>')
    sys.exit()
elif sys.argv[2].lower() not in SONGS:
    print('Invalid song name. Choose from Believer, Cake by the ocean, Shut up and dance, or Thunder')
    sys.exit()
elif sys.argv[3] not in DIFFICULTIES:
    print('Invalid difficulty. Choose from Easy, Medium, Hard, or Expert')
    sys.exit()

# Game variables
generation_speed = 0.6
frame_counter = 0
score = 0
time_left = 20
song_name = sys.argv[2].lower()

# Game elements
game_ended = False
game_started = False
start_screen_elements = {}
play_screen_elements = {}
end_screen_elements = {}

# Game lists
beat_list = []
top_scores = {'name': '', 'score': 0, 'position': 0}
frame = []
column = []
stream = []
direction = []

# Create a function that will set up the start screen
def start_screen_setup():
    start_screen_elements['ready'] = create_element('text-ready', (WIDTH / 2, HEIGHT / 2 - 100))
    start_screen_elements['space'] = create_element('space-bar', (WIDTH / 2, HEIGHT / 2 + 50))
    start_screen_elements['tap'] = create_element('tap-active', (WIDTH / 2 + 70, HEIGHT / 2 + 50))
    start_screen_elements['tap'][VISIBLE] = True
    schedule_callback_every(toggle_tap, .5)

# Create a function that will set up the end screen
def end_screen_setup():
    global game_ended
    game_ended = True
    end_screen_elements['timeup'] = create_element('text-timeup', (WIDTH / 2, HEIGHT / 2))
    end_screen_elements['timeup'][VISIBLE] = True
    schedule_callback_after(hide_timeup, 1)
    
# Create a function that will set up the game screen
def game_screen_setup():
    global game_started
    game_started = True
    cancel_callback_schedule(toggle_tap)
    play_screen_elements['score'] = create_element('star2', (30, 30))
    play_screen_elements['keyboard_arrow'] = create_element('keyboard_arrows_', (WIDTH / 2 + 150, HEIGHT - 60))
    play_screen_elements['keyboard_WASD'] = create_element('keyboard_arrows_', (WIDTH / 2 - 150, HEIGHT - 60))
    play_screen_elements['keyboard_arrow']['base'] = 'keyboard_arrows_'
    play_screen_elements['keyboard_WASD']['base'] = 'keyboard_arrows_'
    play_screen_elements['go'] = create_element('text-go', (WIDTH / 2, HEIGHT / 2))
    play_screen_elements['go'][VISIBLE] = True
    schedule_callback_after(hide_go, .5)
        
# Hide the 'go' text
def hide_go():
    play_screen_elements['go'][VISIBLE] = False

# Hide the 'timeup' text
def hide_timeup():
    end_screen_elements['timeup'][VISIBLE] = False

# Toggle the visibility of the 'tap' text
def toggle_tap():
    start_screen_elements['tap'][VISIBLE] = not start_screen_elements['tap'][VISIBLE]

# Draw the elements on the screen
def draw():
    """
    - Called automatically everytime there's a change in the screen
    - Do not include any operations other than drawing inside this function.
    - The only allowed statements/functions are the ones that have draw_ in the name like
    draw_background_image(), draw_element(), etc
    """
    # Draw the background image
    draw_background('background4')

    if not game_started:
        # What you want to show *before* the game starts goes here. eg 'Press Space to Start!'
        for game_element in start_screen_elements.values():
            if VISIBLE not in game_element or game_element[VISIBLE]:
                draw_element(game_element)
    elif game_ended:
        # What you want to show *after* the game ends goes here. eg 'You Scored x Beats!'
        for game_element in end_screen_elements.values():
            if VISIBLE not in game_element or game_element[VISIBLE]:
                draw_element(game_element)
            else:
                draw_text_on_screen(f'SCORE\n{score}', (WIDTH / 2, HEIGHT / 2), lineheight=1.2, ocolor='lightseagreen', owidth=1.5, color="white", fontsize=100)
    else:
        # Draw the score
        draw_text_on_screen(f'{score}', (70, 32), color='yellow', fontsize=40)
        draw_text_on_screen(f'{frame_counter}', (150, 32), color='black', fontsize=40)

        # Draw the game elements on the screen
        for game_element in play_screen_elements.values():
            if VISIBLE not in game_element or game_element[VISIBLE]:
                draw_element(game_element)

        # Draw the beats
        for beat in beat_list:
            draw_element(beat)

# Update the elements on the screen
def update():
    """
    - Called automatically 60 times per second (every 1/60th of a second) to
    maintain a smooth frame rate of 60 fps.
    - Ideal for game logic e.g. moving objects, updating score, and checking game conditions.
    """
    global frame_counter, game_started, game_ended, score, frame, stream, direction

    if not game_started:
        # Game logic if any *before* the game starts.
        pass

    elif game_ended:
        # Game logic if any *after* the game ends.
        pass

    else:
        frame_counter += 1
        # Remove the beats that are out of the screen
        while frame[0] < 0:
            frame.pop(0)
            stream.pop(0)
            direction.pop(0)
        # Generate beats based on the frame
        while frame and frame_counter == frame[0]:
            generate_beat()
            # Remove the frame, stream, and direction of the beat that was generated
            frame.pop(0)
            stream.pop(0)
            direction.pop(0)
        # Move the beats down the screen
        for beat in beat_list:
            if beat['moving']:
                move_by_offset(beat, (0, SPEED))
                # Check if the beat is out of the screen
                if get_position(beat, 'bottom') >= HEIGHT:
                    beat['moving'] = False
                    beat['scoreStatus'] = 'miss'
                    score_beat(beat)
            elif beat['scoreStatus']:
                # Score the beat if it was hit inside the hit zone or missed
                if beat['scoreStatus'] == 'hit' and 550 <= get_position(beat, 'bottom') <= 650 and 550 <= get_position(beat, 'top') <= 650:
                    score_beat(beat)
                else:
                    beat['scoreStatus'] = 'miss'
                    score_beat(beat)
        # Game ends if user's score is less than 0 or song ends
        if score < 0 or not manage_background_music(song_name, 'is-playing'):
            end_game()

def on_key_down(key):
    
    key_pressed = get_key_pressed(key)

    # Check if the game has not started and the key pressed is the space bar to start game
    if key_pressed == 'space' and not game_started:
        start_game()
        return

    # Check if the game has started and the key pressed is a valid key
    if key_pressed not in WASD and key_pressed not in BEAT_DIRECTIONS:
        return

    try:
        '''
        - Check if the key pressed is a valid key
        - Lowest beat is the beat that is closest to the bottom of the correct stream
        - Change the image of the keyboard arrow or WASD key to the pressed key
        - Schedule a callback to change the image back to the base image
        '''
        if key_pressed in WASD:
            lowest_beat = find_lowest_moving_left()
            key_pressed = WASD_TO_ARROW[key_pressed]
            change_image(play_screen_elements['keyboard_WASD'], play_screen_elements['keyboard_WASD']['base'] + key_pressed)
        elif key_pressed in BEAT_DIRECTIONS:
            lowest_beat = find_lowest_moving_right()
            change_image(play_screen_elements['keyboard_arrow'], play_screen_elements['keyboard_arrow']['base'] + key_pressed)
        schedule_callback_after(keyboard_arrow_change_back, .1)
    except KeyError:
        pass
    
    # If lowest beat direction is the same as the key pressed, score the beat as hit, otherwise score as miss
    if not game_ended and lowest_beat and key_pressed in BEAT_DIRECTIONS:
        lowest_beat['moving'] = False
        if lowest_beat['direction'] == key_pressed:
            lowest_beat['scoreStatus'] = 'hit'
        else:
            lowest_beat['scoreStatus'] = 'miss'
    else:
        pass

# Create a function that will change the image of the keyboard arrow or WASD key back to the base image
def keyboard_arrow_change_back():
    change_image(play_screen_elements['keyboard_WASD'], play_screen_elements['keyboard_WASD']['base'])
    change_image(play_screen_elements['keyboard_arrow'], play_screen_elements['keyboard_arrow']['base'])

# Create a function that will play the sound clip of the beat being hit or missed
def score_beat(beat):
    global score
    status = beat['scoreStatus']
    beat['scoreStatus'] = ''
    direction = beat['direction']
    change_image(beat, direction + '-' + status)
    # Play the sound clip of the beat being hit or missed
    if status == 'hit':
        play_sound_clip(status + '1')
    else:
        play_sound_clip(status + '3')
    # Check if the beat is in the hit zone
    if status == 'hit':
        score += 2
    else:
        score -= 1
        # Score cannot be less than 0
        if score < 0:
            score = 0
    if beat['stream'] == 'Left':
        schedule_callback_after(remove_lowest_left_beat, .2)
    else:
        schedule_callback_after(remove_lowest_right_beat, .2)

# Create a function that will remove the lowest beat from the beat list
def remove_lowest_beat():
    if beat_list:
        beat_list.pop(0)

def remove_lowest_left_beat():
    if beat_list:
        for beat in beat_list:
            if beat['stream'] == 'Left':
                beat_list.remove(beat)
                break

def remove_lowest_right_beat():
    if beat_list:
        for beat in beat_list:
            if beat['stream'] == 'Right':
                beat_list.remove(beat)
                break

# Create a function that will find the lowest moving right beat
def find_lowest_moving_right():
    # Iterate over the beat_list
    for beat in beat_list:
        # Check if the beat is moving and in the right stream
        if beat['moving'] and beat['stream'] == 'Right':
            return beat
    # If no beat is found, return None
    return None

# Create a function that will find the lowest moving left beat
def find_lowest_moving_left():
    # Iterate over the beat_list
    for beat in beat_list:
        # Check if the beat is moving and in the left stream
        if beat['moving'] and beat['stream'] == 'Left':
            return beat
    # If no beat is found, return None
    return None

# Create a function that will start the game
def start_game():
    game_screen_setup()
    song_data()
    manage_background_music(song_name, 'play-once')
    manage_background_music(song_name, 'change-volume', volume=0.3)

# Create a function that will end the game
def end_game():
    find_top_scores()
    end_screen_setup()
    frame.clear()
    stream.clear()
    direction.clear()
    beat_list.clear()
    manage_background_music(song_name, 'stop')

# Create a function that will find the top scores
def find_top_scores():
    top_scores['score'] = score
    top_scores['name'] = sys.argv[1]

    # Read the top scores from the top_scores.csv file
    try:
        with open('top10.csv', 'r') as file:
            scores = file.readlines()
    except FileNotFoundError:
        with open('top10.csv', 'w') as file:
            file.write('Name, Song, Difficulty, Score\n')
            scores = []

    # Make a new score entry
    new_score = f'[Name: {top_scores['name']}, Song: {song_name.capitalize()}, Difficulty: {sys.argv[3]}, Score: {top_scores['score']}]\n'
    scores.append(new_score)

    # Sort the scores in descending order
    scores.sort(key=lambda s: int(s.split('Score: ')[1].split(']')[0]), reverse=True)

    # Write the top scores to the top_scores.csv file
    with open('top10.csv', 'w') as file:
        file.writelines(scores)

# Create a function that parses the song data
def song_data():
    # Read the song data from the file
    song_playing = sys.argv[2].lower()
    difficulty = sys.argv[3].capitalize()
    song_file = f"{song_playing}/{difficulty}.beat"

    try:
        # Parse the song data
        with open(song_file, 'r') as file:
            next(file) # skip the header
            for line in file:
                beat_map = line.strip().split()
                if beat_map:
                    # Append the frame, stream, and direction of the beat
                    frame.append(int(beat_map[0]))
                    stream.append(beat_map[2])
                    direction.append(beat_map[3])
    except FileNotFoundError:
        print(f'Error: {song_file} not found')
        sys.exit()
    except ValueError:
        print(f'Could not parse {song_file} properly. Check the file format.')
    
    return frame, stream, direction

# Create a function that will generate a beat
def generate_beat():
    side = 0
    beat_direction = direction[0].lower()
    # Set the side of the beat based on the stream
    if stream[0] == 'Left':
        side = -1
    elif stream[0] == 'Right':
        side = 1
    beat = create_element(beat_direction + '-beat', centerPos=(WIDTH / 2 + side * 150, 0))
    beat['stream'] = stream[0]
    beat['moving'] = True
    beat['frame'] = frame[0]
    beat['scoreStatus'] = ''
    beat['direction'] = beat_direction
    beat_list.append(beat)

# # # # # # # # # # # # # # # # # # # # # # # # # # #
# # # # # # DO NOT REMOVE THIS LINE!! # # # # # # # #
start_screen_setup()
run_game()
# # # # # # # # # # # # # # # # # # # # # # # # # # #
# # # # # # # # # # # # # # # # # # # # # # # # # # #
