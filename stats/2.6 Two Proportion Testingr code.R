pm=102/200
pw=38/100
p=(102+38)/(200+100)

ts=(pm-pw)/(p*(1-p)*(1/200+1/100))^.5

prop.test(x = c(102,38),n = c(200,100),alternative = "two.sided",correct = F)
4.526786^.5

prop.test(x = c(102,38),n = c(200,100),alternative = "greater",correct = F)
prop.test(x = c(102,38),n = c(200,100),alternative = "less",correct = F)

#######

prop.test(x = c(38,102),n = c(100,200),alternative = "less",correct = F,conf.level = .99)


#######

prop.test(x = c(88,33),n = c(200,200),alternative = "greater",correct = F,conf.level = .95)
prop.test(x = c(88,33),n = c(200,200),alternative = "two.sided",correct = F,conf.level = .95)
prop.test(x = c(88,33),n = c(200,200),alternative = "less",correct = F,conf.level = .95)

######

prop.test(x=c(160,90),n=c(400,300),alternative = "two.sided",correct = F,conf.level = .9)


prop.test(x=c(160,90),n=c(400,300),alternative = "less",correct = F,conf.level = .9)
prop.test(x=c(160,90),n=c(400,300),alternative = "greater",correct = F,conf.level = .9)


