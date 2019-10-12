<?php

/**
 * Interface ICommand
 */
interface ICommand{
    public function execute();
}

/**
 * Command
 * Class UpdatePriceCommand
 */
class UpdatePriceCommand implements ICommand
{
    private $action;

    public function __construct(StockMarket $action)
    {
        $this->action = $action;
    }

    public function execute()
    {
        $this->action->updatePrice();
    }
}

/**
 * Command
 * Class UpdateSizeCommand
 */
class UpdateSizeCommand implements ICommand
{
    private $action;

    public function __construct(StockMarket $action)
    {
        $this->action = $action;
    }

    public function execute()
    {
        $this->action->updateSize();
    }
}

/**
 * Receiver
 * Class StockMarket
 */
class StockMarket
{
    public function updatePrice()
    {
        echo "Update Price";
    }

    public function updateSize()
    {
        echo "Update Size";
    }
}

/**
 * Invoker
 * Some action
 */
function someAction(){

    $type = 'UpdateSizeCommand';
//    $type = 'UpdatePriceCommand';

    return $type;
}

$input = someAction();

/**
 * Client
 */
$command = new $input(new StockMarket());

$command->execute();

