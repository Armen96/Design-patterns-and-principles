<?php

/**
 * Adapters are helpful if you want to use a class that doesn't have quite the exact methods you need,
 * and you can't change the orignal class.
 * The adapter can take the methods you can access in the original class,
 * and adapt them into the methods you need.
 */

interface ISocialMediaAdapter
{
    public function post($msg);
}

class Facebook
{
    public function postMessage($msg)
    {
        echo "Posting message...";
    }
}

class FacebookAdapter implements ISocialMediaAdapter
{
    private $facebook;

    public function __construct(Facebook $facebook)
    {
        $this->facebook = $facebook;
    }

    public function post($msg)
    {
        $this->facebook->postMessage($msg);
    }
}

$fb = new FacebookAdapter(new Facebook());

$message = "Some message";

//...

$fb->post($message);
