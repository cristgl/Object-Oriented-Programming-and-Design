# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
  #require 'singleton'
module NapakalakiGame

class Dice
  #include Singleton
  
  @@instance=nil
  def self.instance
        if(@@instance==nil)
          @@instance=new
        end
        @@instance
    end
  private_class_method :new
  def initialize
  end
 
    
  def nextNumber
    rand(6)+1
  end
end
end
