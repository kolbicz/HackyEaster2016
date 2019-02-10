for ((i=1000; i>1; i--))
do
    unzip *.zip ; rm *.zip
    cd */
    git show | grep differ >>../log.txt
    git ls-files -d | xargs git checkout --
    mv *.zip ../
    cd ..
done

