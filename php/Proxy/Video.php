<?php


interface IVideo {
    public function play();
}

class Video implements IVideo
{
    private $title;

    public function __construct($title)
    {
        $this->title = $title;
    }

    public function play()
    {
        echo "Playing ". $this->title. ' video';
    }
}

class VideoProxy implements IVideo
{
    private $title;
    private $video;

    public function __construct($title)
    {
        $this->title = $title;
    }

    public function play()
    {
        if( $this->video == null ) $this->video = new Video($this->title);

        return $this->video->play();
    }
}

$ex = new VideoProxy(" WOW ");
$ex->play();