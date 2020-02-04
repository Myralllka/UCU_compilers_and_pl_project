

echo "################## IMPORTANT ##################"
echo "This script will download and build all necessary components to work on & with GraalVM and truffle. Beware that the setup might take up to 20min..."
echo "If you do not wish to do that please press CTRL+C in the next few seconds..."

echo "10s"
sleep 1s
echo "9s"
sleep 1s
echo "8s"
sleep 1s
echo "7s"
sleep 1s
echo "6s"
sleep 1s
echo "5s"
sleep 1s
echo "4s"
sleep 1s
echo "3s"
sleep 1s
echo "2s"
sleep 1s
echo "1s"
sleep 1s

echo "Checking if git is installed..."
if ! [ -x "$(command -v git)" ]; then
    echo 'git is not installed, please install git before proceeding.' >&2
    exit 1
else
    echo 'git up and running'
fi

echo "Checking if python is installed..."
if ! [ -x "$(command -v python --version)" ]; then
    echo 'python is not installed, please install python before proceeding.' >&2
    exit 1
else
    echo 'python up and running'
fi

echo "creating directory structure..."

mkdir Slides

echo "Fetching the slides..."

# wget 

mkdir Source
mkdir IDE
mkdir IDE/ws

echo "fetching JVMCI enabled JDK for linux"

wget https://github.com/graalvm/openjdk8-jvmci-builder/releases/download/jvmci-19.3-b06/openjdk-8u232-jvmci-19.3-b06-linux-amd64.tar.gz

mv openjdk-8u232-jvmci-19.3-b06-linux-amd64.tar.gz Source

echo "fetching newest version of eclipse"
echo "if this cmd fails the remote link likely has changed, please perform IDE steps yourself"

wget http://ftp-stud.fht-esslingen.de/pub/Mirrors/eclipse/technology/epp/downloads/release/2019-12/R/eclipse-java-2019-12-R-linux-gtk-x86_64.tar.gz

mv eclipse-java-2019-12-R-linux-gtk-x86_64.tar.gz IDE

cd IDE 

tar -xvzf eclipse-java-2019-12-R-linux-gtk-x86_64.tar.gz
rm eclipse-java-2019-12-R-linux-gtk-x86_64.tar.gz

cd ..

cd Source

tar -xvzf openjdk-8u232-jvmci-19.3-b06-linux-amd64.tar.gz
rm openjdk-8u232-jvmci-19.3-b06-linux-amd64.tar.gz


echo "building graal"

echo "Cloning mx repo"

git clone --depth 10 https://github.com/graalvm/mx.git

echo "Cloning graal repo"

git clone --depth 10  https://github.com/oracle/graal.git

cd graal 

cd compiler


../../mx/mx --java-home ../../openjdk1.8.0_232-jvmci-19.3-b06 sversions
../../mx/mx --java-home ../../openjdk1.8.0_232-jvmci-19.3-b06 build
../../mx/mx --java-home ../../openjdk1.8.0_232-jvmci-19.3-b06 eclipseinit
../../mx/mx --java-home ../../openjdk1.8.0_232-jvmci-19.3-b06 vm -XX:+EnableJVMCI -XX:+UseJVMCICompiler -XX:+BootstrapJVMCI -version


cd ..

cd ..

echo "Fetching micro java sources"

wget http://davidleopoldseder.com/teaching/trufflecourse.tar.gz

tar -xvzf trufflecourse.tar.gz
rm trufflecourse.tar.gz

cd trufflecourse

env JAVA_HOME=../openjdk1.8.0_232-jvmci-19.3-b06 ../mx/mx --dy /compiler  --jdk jvmci build
env JAVA_HOME=../openjdk1.8.0_232-jvmci-19.3-b06 ../mx/mx --dy /compiler  --jdk jvmci eclipseinit
env JAVA_HOME=../openjdk1.8.0_232-jvmci-19.3-b06 ../mx/mx --dy /compiler  --jdk jvmci build

env JAVA_HOME=../openjdk1.8.0_232-jvmci-19.3-b06 ../mx/mx --dy /compiler  --jdk jvmci peSamples
env JAVA_HOME=../openjdk1.8.0_232-jvmci-19.3-b06 ../mx/mx --dy /compiler  --jdk jvmci mjInterpreter


echo "In order to download IGV and/or graalVM visit https://www.oracle.com/downloads/graalvm-downloads.html"

exit 1

