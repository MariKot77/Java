package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * Этот класс хранит базовое состояние, необходимое для алгоритма А* для вычисления пути по карте,
 * включает в себя наборы "открытых точек" и "закрытых точек".
 * Этот класс предостовляет основные операции, необходимые алгоритму поиска пути А* для его выполнения
 **/


public class AStarState
{
    //Ссылка на карту, по которой перемещается А*
    private final Map2D map;

    //Инициализируем хэшкарту открытых точек и их местоположений
    private final HashMap<Location, Waypoint> openWaypoints = new HashMap<>();

    //Инициализируем хэшкарту открытых точек и их местоположений
    private final HashMap<Location, Waypoint> closeWaypoints = new HashMap<> ();

    //Инициализируем новый объект для алгоритма A*
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    //Возвращает карту, по которой перемещается А*
    public Map2D getMap()
    {
        return map;
    }

    /**
     Эта функция должна проверить все точки в наборе открытых точек,
     и после этого она должна вернуть ссылку на точку с наименьшей общей стоимостью.
     Если в "открытом" наборе нет точек, функция возвращает NULL.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // если в "открытом" наборе нет точек, функция возвращает NULL
        if (numOpenWaypoints() == 0)
            return null;
        //инициализируем переменную для записи в нее списка всех ключей открытых точек
        Set<Location> openWaypointKeys = openWaypoints.keySet();
        //инициализируем итератор для того, чтобы пройти по всем ключам
        Iterator<Location> i = openWaypointKeys.iterator();
        //инициализируем переменную для записи лучшей по цене точки
        Waypoint best = null;
        //инициализируем переменную для записи лучшей цены
        float bestCost = Float.MAX_VALUE;

        //проверяем все открытые вершины
        while (i.hasNext())//возвращает true, если есть еще значения в списке
        {
            //запоминаем текущую позицию
            Location location = i.next();
            //запоминаем текущую вершину
            Waypoint waypoint = openWaypoints.get(location);
            //запоминаем стоимость текущей вершины
            float waypointTotalCost = waypoint.getTotalCost();

            //если стоимость текущей вершины меньше, то запоминаем текущую вершину,
            //как наиболее подходящую, и меняем лучшую стоимость
            if (waypointTotalCost < bestCost)
            {
                best = openWaypoints.get(location);
                bestCost = waypointTotalCost;
            }
        }
        //возвращаем вершину с лучшей (наименьшей) стоимостью
        return best;
    }

    /**
      Если в наборе «открытых точек» в настоящее время нет точки
      для данного местоположения, то метод добавляет новую точку.
      Если в наборе «открытых точек» уже есть точка для этой локации,
      метод добавляет новую точку только в том случае,
      если стоимость пути до новой точки меньше стоимости пути до текущей.
      Другими словами, если путь через новую точку короче,
      чем путь через текущую точку, замените текущую точку на новую
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        //находим локацию новой вершины
        Location location = newWP.getLocation();

        //проверяем, есть ли в наборе открытых вершин вершина с такой локацией
        if (openWaypoints.containsKey(location))
        {
            //если вершина с такой локацией уже есть в наборе открытых вершин
            //стоимость пути должна быть меньше, чтобы мы записали ее снова
            Waypoint currentWaypoint = openWaypoints.get(location);
            if (newWP.getPreviousCost() < currentWaypoint.getPreviousCost())
            {
                //если стоимость пути до текущей точки меньше чем до предыдущей,
                //перезаписываем ее в набор открытых вершин и возвращаем true
                openWaypoints.put(location, newWP);
                return true;
            }
            //если стоимость пути до текущей точки неменьше чем до предыдущей, возвращаем true
            return false;
        }
        //если в наборе открытых вершин не было вершины с этой локацией,
        //записываем ее в набор и возвращаем true
        openWaypoints.put(location, newWP);
        return true;
    }


    //Этот метод возвращает количество точек в наборе открытых вершин
    public int numOpenWaypoints()
    {
        return openWaypoints.size();
    }

    /**
      Этод метод перемещает вершину из набора открытых вершин
      в набор закрытых вершин
     **/
    public void closeWaypoint(Location loc)
    {
        //записываем значение вершины удаляемой из набора открытых вершин
        Waypoint waypoint = openWaypoints.remove(loc);
        //добавляем в набор закрытых вершин, данную вершину и ее местоположение
        closeWaypoints.put(loc, waypoint);
    }

    /**
      Этод метод возвращает значение true, если указанное местоположение
      встречается в наборе закрытых вершин, и false в противном случае.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return closeWaypoints.containsKey(loc);
    }
}
