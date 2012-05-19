def combine_anagrams(words)
  ha = {}
  words.each do |w|
    wd = w.downcase.split(//).sort.join
    if ha[wd]
      ha[wd] << w
    else
      ha[wd] = [w]
    end
  end
  ret = []
  ha.each_value do |v|
    ret << v
  end
  return ret
end

#a = ['cars', 'for', 'potatoes', 'racs', 'four','scar', 'creams', 'scream']
#puts combine_anagrams(a).inspect
