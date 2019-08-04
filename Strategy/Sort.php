<?php

/**
 * In Strategy pattern, we create objects
 * which represent various strategies and a context object
 * whose behavior varies as per its strategy object.
 * The strategy object changes the executing algorithm of the context object.
 */

require ('SortStratagy.php');

class Sort
{
    private $data;

    public function __construct($data)
    {
        $this->data = $data;
    }

    public function sort()
    {
        $sortType = 'MergeSort';
        switch ($this->data) {
            case count($this->data) < 5 :
                $sortType = 'BubbleSort';
                break;
            case count($this->data) < 50 :
                $sortType = 'QuickSort';
                break;
        }

        $sortInstance = new $sortType($this->data);
        return $sortInstance->sort();
    }
}

class QuickSort implements SortStratagy
{
    private $data;

    public function __construct($data)
    {
        $this->data = $data;
    }

    public function sort()
    {
        // TODO: Implement sort() method.

        // Quick Sort

        return [
            "type" => 'QuickSort',
            $this->data
        ];
    }
}

class MergeSort implements SortStratagy
{
    private $data;

    public function __construct($data)
    {
        $this->data = $data;
    }

    public function sort()
    {
        // TODO: Implement sort() method.

        // Merge Sort

        return [
            "type" => 'MergeSort',
            $this->data
        ];
    }
}

class BubbleSort implements SortStratagy
{
    private $data;

    public function __construct($data)
    {
        $this->data = $data;
    }

    public function sort()
    {
        // TODO: Implement sort() method.

        // Bubble Sort

        return [
            "type" => 'BubbleSort',
            $this->data
        ];
    }
}

$data = [1,2,3,4,2,5,4,6,8,4];
$sort = new Sort($data);

var_dump($sort->sort());
