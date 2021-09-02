date=`date |sed 's| |_|g'`
cd /home/xxx/xxx
git add .
git commit -m "进行备份，当前时间为$date"
