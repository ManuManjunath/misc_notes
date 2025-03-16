import random

continents = ['Asia', 'Africa', 'Europe', 'Oceania', 'N America', 'S America', 'Antarctica']
# Set initial points
points = dict()
for c in continents:
    points[c] = 3

def end_of_continent():
    # Check if any continent has lost all of their points. If they have, end of game for them.
    global points, continents
    for c in continents:
        if points[c] == 0:
            points.pop(c, None)
            continents = [i for i in continents if i != c]
            print(f"{c} has been wiped off from the planet.")
    
def war():
    # WAR! Intercontinental relations are about to take a hit.
    # The continent with higher points will win and steal an additional point from the loser.
    global points, continents
    attacker = random.choice(continents)
    # Lets avoid continents attacking themselves.
    defending_continents = [i for i in continents if i != attacker]
    defender = random.choice(defending_continents)
    
    if points[attacker] > points[defender]:
        print(f"{attacker} attacked {defender} and won")
        points[attacker] += 1
        points[defender] -= 1
    elif points[attacker] < points[defender]:
        print(f"{attacker} attacked {defender} and lost")
        points[attacker] -= 1
        points[defender] += 1
    else:
        print(f"{attacker} attacked {defender}. Its a stalemate.")

    # Check if all the continents are still in the game.
    end_of_continent()
        
    # Let us see how the points table look at the end of this round
    print(points)

def grow(continent):
    # It is time for peace and prosperity.
    # There will be a continent wide welfare and they'll get a point.
    global points, continents
#    global continents
    print(f"{continent} has grown in power")
    points[continent] += 1
    # Let us see how the points table look at the end of this round
    print(points)

def choose_action():
    # Choose what action to take. 
    # Will it be growth and prosperity or will it be WAR!!!
    global continents
    if len(continents) == 0:
        # Shouldn't come to this
        print("There is only one continent left on this planet. Game has ended.")
    else:
        act = random.choice(['war', 'grow'])
        if act == 'war':
            war()
        elif act == 'grow':
            grow(random.choice(continents))
        else:
            # Shouldn't come to this
            print("Invalid selection")

while (len(continents) > 1):
    # Continue running battle simulation until there is only ONE entity left
    if len(continents) > 1:
        choose_action()

print(f"Game ended. {continents[0]} is the winner!")
