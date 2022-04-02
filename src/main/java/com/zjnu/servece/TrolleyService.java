package com.zjnu.servece;

import com.zjnu.pojo.Trolley;

import java.util.List;

public interface TrolleyService {
    List<Trolley> selectTrolley(Trolley trolley);
}
