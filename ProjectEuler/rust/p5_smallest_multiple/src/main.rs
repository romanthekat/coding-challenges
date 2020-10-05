fn main() {
    println!("Smallest multiple: {}", get_smallest_multiple(1, 20));
}

fn get_smallest_multiple(min: i32, max: i32) -> i32 {
    let mut num = max;
    loop {
        num = num + 1;
        if is_evenly_divisible(num, min, max) {
            return num;
        }
    }
}

fn is_evenly_divisible(num: i32, min: i32, max: i32) -> bool {
    for divider in min..=max {
        if num % divider != 0 {
            return false;
        }
    }

    return true;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn smallest_multiple_10() {
        assert_eq!(get_smallest_multiple(1, 10), 2520);
    }

    //#[test]
    //fn smallest_multiple_20() {
    //    assert_eq!(!get_smallest_multiple(1, 20), 232792560);
    //}
}