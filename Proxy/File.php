<?php

/**
 * In the proxy pattern one class stands in for and handles all access to another class.
 * This can be because the real subject is in a different location (server, platform, etc),
 * the real subject is cpu or memory intensive to create and is only created if necessary,
 * or to control access to the real subject.
 * A proxy can also be used to add additional access functionality,
 * such as recording the number of times the real subject is actually called.
 */

interface File
{
    public function display(): void;
}

class RealFile implements File
{
    private $fileName, $content;

    public function __construct(string $fileName)
    {
        $this->fileName = $fileName;

        $this->load($fileName);
    }

    public function load(string $fileName): void
    {
        echo "Loading '$fileName'..." . '<br>';

        $openedFile = fopen($fileName, "r");

        $this->content = fread($openedFile, filesize($this->fileName));
    }

    public function display(): void
    {
        echo $this->content;
    }
}

class ProxyFile implements File
{
    private $realFile, $fileName;

    public function __construct($fileName)
    {
        $this->fileName = $fileName;
    }

    public function display(): void
    {
        if ($this->realFile == null)
            $this->realFile = new RealFile($this->fileName);

        echo $this->realFile->display();
    }
}

$image = new ProxyFile('test.txt');
$image->display();
echo '<br><br>File already loaded from disk before, thus just display it now!<br>';
$image->display();