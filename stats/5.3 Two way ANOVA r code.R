distance=c(202.4,242,220.4,230,191.6,247.7,214.8,245.4,224,252.2,203.2,248.7,227.3,243.1,211.4,253,214.8,243.6,231.5,255.2,223.7,259.8,240,247.7,218.7,268.1,233.9,257.8,238.2,265.4,203.6,240.7,207.4,226.9,200.1,244,195.8,227.9,215.7,245.2)
brand=c(rep("A",10),rep("B",10),rep("C",10),rep("D",10))
golfer=c(rep(c(1,2,3,"John 4",5,"Jeff B. 6",7:10),4))

df=data.frame(distance,brand,golfer)
xtabs(df)


#golf1 <- read.csv("~/golfer1.csv")
df=golf1[2:4]

df

library(car)
leveneTest(distance~brand,data = df)

subset(df, brand == "B", select = distance)
subset(df, brand == "B", select = distance)[,1]

library(nortest)
ad.test(subset(df, brand == "A", select = distance)[,1])
ad.test(subset(df, brand == "B", select = distance)[,1])
ad.test(subset(df, brand == "C", select = distance)[,1])
ad.test(subset(df, brand == "D", select = distance)[,1])

my.anova=aov(distance~brand,data = df)
summary(my.anova)
TukeyHSD(my.anova,conf.level = .95)

library(ggpubr)
ggline(df, y = "distance", x = "brand", add = c("mean_se", "jitter"))


my.anova=aov(distance~brand+golfer,data = df)
summary(my.anova)

library(ggplot2)
ggplot(df, aes(fill=brand, y=distance, x=golfer))+geom_bar(position="dodge", stat="identity")
ggplot(df, aes(fill=golfer, y=distance, x=brand))+geom_bar(position="dodge", stat="identity")




my.anova=aov(distance~golfer,data = df)
summary(my.anova)
TukeyHSD(my.anova,conf.level = .95)
library(ggpubr)
ggline(df, y = "distance", x = "golfer", add = c("mean_se", "jitter"))


interaction.plot(x.factor = df$brand,trace.factor = df$golfer,response = df$distance,type = "b",legend = F)
interaction.plot(x.factor = df$golfer,trace.factor = df$brand,response = df$distance,type = "b",legend = F)

