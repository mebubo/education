class WrongNumberOfPlayersError < StandardError ; end
class NoSuchStrategyError < StandardError ; end

VALID = ["r", "p", "s"]

def rps_game_winner(game)
  raise WrongNumberOfPlayersError unless game.length == 2
  # your code here
  s1 = game[0][1].downcase
  s2 = game[1][1].downcase
  if ! (VALID.include? s1 and VALID.include? s2)
    raise NoSuchStrategyError
  end
  if s1 == s2
    return game[0]
  end
  if s1 == 'r'
    if s2 == 'p'
      return game[1]
    else
      return game[0]
    end
  elsif s1 == 'p'
    if s2 == 's'
      return game[1]
    else
      return game[0]
    end
  else
    if s2 == 'r'
      return game[1]
    else
      return game[0]
    end
  end
end

# print rps_game_winner([["1", "s"], ["2", "r"]])

t = [ [ ["Armando", "P"], ["Dave", "S"] ], [ ["Richard", "R"], ["Michael", "S"] ] ]

def rps_tournament_winner(tournament)
  if tournament[0][0].class == String
    return rps_game_winner(tournament)
  else
    return rps_game_winner([rps_tournament_winner(tournament[0]), rps_tournament_winner(tournament[1])])
  end
end

# print rps_tournament_winner(t)
