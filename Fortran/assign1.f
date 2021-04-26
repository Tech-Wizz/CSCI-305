        program SuperSpy
                Implicit none
                INTEGER num, first, second

                write (*,*) 'Hat size?'
                read*, num     

                second = num/10**2-10*(num/10**(2+1))
                !find the thirds digit 

                first = num/10**1-10*(num/10**(1+1))
                !finds the second digit
                
                if (num>100) then
                        write(*,*) 'Use', first, second
                else
                        write(*,*) 'Size not big enough'
                end if

        end program SuperSpy
