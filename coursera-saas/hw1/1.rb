def palindrome?(string)
  # your code here
  s = string.downcase.gsub(/\W/, "")
  return s.reverse == s
end

# print palindrome?("A man, a plan, a canal -- Panama")
# print "\n"
# print palindrome?("Abracadabra")
# print "\n"

def count_words(string)
  # your code here
  ret = {}
  s = string.downcase
  s.split(/\b/).each do |w|
    if w =~ /\w/
      if ret[w]
        ret[w] += 1
      else
        ret[w] = 1
      end
    end
  end
  return ret
end

# print count_words("A man, a plan, a canal -- Panama")
