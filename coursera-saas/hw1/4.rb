class Dessert

  def initialize(name, calories)
    @name = name
    @calories = calories
  end

  attr_accessor :calories

  def name
    @name
  end

  def name=(name)
    @name = name
  end
  
  def healthy?
    @calories < 200
  end

  def delicious?
    true
  end

end

class JellyBean < Dessert
  def initialize(name, calories, flavor)
    @flavor = flavor
    super(name, calories)
  end

  attr_accessor :flavor
  
  def delicious?
    @flavor != "black licorice"
  end
end
