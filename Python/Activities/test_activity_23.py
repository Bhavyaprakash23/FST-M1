import pytest

@pytest.fixture
def number_list():
    return list(range(11))

def test_sum(number_list):
    assert sum(number_list)==55