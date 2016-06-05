package dev.dungdm93.gjt;

import org.springframework.stereotype.Service;

@Service
public class GjtService {
    public int boundedMultiply(int lhs, int rhs) {
        int result = lhs * rhs;
        if (result > 100) result = 100;
        if (result < 0) result = 0;
        return result;
    }
}
