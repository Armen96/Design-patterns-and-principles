<?php

/**
 * Singleton Pattern
 *
 * This pattern involves a single class which is responsible to create an object
 * while making sure that only single object gets created.
 * This class provides a way to access its only object
 * which can be accessed directly without need to instantiate the object of the class.
 */

class Database
{
    private static $table;
    public static $instance;

    private function __construct($table)
    {
        static::$table = $table;
    }

    public static function getInstance($table)
    {
        if(!isset(static::$instance))
            static::$instance = new Database($table);

        return static::$instance;
    }

    public function selectQuery()
    {
        return 'select * from '. static::$table;
    }
}

$model = Database::getInstance('users');
$mode12 = Database::getInstance('users');

var_dump($model); // object(Database)#1 (0) {}
var_dump($mode12); // object(Database)#1 (0) {}


echo $model->selectQuery(); // select * from users